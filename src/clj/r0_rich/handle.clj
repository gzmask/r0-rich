(ns r0_rich.handle
  (:use compojure.core
        r0_rich.pages.page
        r0_rich.controls.home
        r0_rich.controls.store
        r0_rich.controls.webdev
        r0_rich.controls.repair
        r0_rich.controls.port
        r0_rich.controls.about
        r0_rich.controls.no
        r0_rich.pages.css
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/style.css" [] (css))
  (route/resources "/")
  (GET "/" [] (home))
  (GET "/home" [] (home))
  (GET "/reginastore" [] (store))
  (GET "/webdesign" [] (webdev))
  (GET "/pcrepair" [] (repair))
  (GET "/portfolio" [] (port))
  (GET "/about" [] (about))
  (route/not-found (no)))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 3000 :join? false}))


(comment "repl: cpr - load all cpp - eval at point"
(defonce server (run-jetty #'app {:port 3000 :join? false}))
(.start server)
(.stop server)
)
