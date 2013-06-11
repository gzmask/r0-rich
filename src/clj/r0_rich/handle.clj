(ns r0_rich.handle
  (:use compojure.core
        hiccup.core
        hiccup.page
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn index-page []
  "index page for richever"
  (html5
   [:head 
    [:title "Richever Technology Ltd. Regina Saskatchewan"]
    (include-css "/vendor/bootstrap/css/bootstrap.min.css")
    (include-css "/css/style.css")
    (include-js "/vendor/bootstrap/js/bootstrap.min.js")
    (include-js "/app.js")]
   [:body
    [:h1 [:a {:href "http://www.richever.ca"} "richever"]]]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 3000 :join? false}))
