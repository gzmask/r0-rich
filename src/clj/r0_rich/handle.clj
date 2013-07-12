(ns r0_rich.handle
  (:use compojure.core
        r0_rich.controls.control
        r0_rich.pages.css
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/style.css" [] (css))
  (route/resources "/")
  (GET "/" [] (home home_news))
  (GET "/home" [] (home home_news))
  (GET "/reginastore" [] (store store_news))
  (GET "/webdesign" [] (webdev dev_news))
  (GET "/pcrepair" [] (repair repair_news))
  (GET "/portfolio" [] (port gallery_news))
  (GET "/about" [] (about team_news))
  (route/not-found (no no_news)))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 3000 :join? false}))

(comment "repl"
(defonce server (run-jetty #'app {:port 3000 :join? false}))
(.start server)
(.stop server))
