(ns r0_rich.handle
  (:use compojure.core
        hiccup.core
        hiccup.page
        ring.adapter.jetty)
  (:require [gaka [core :as gaka]]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(def in-css (gaka/css [:div.navigation_bar 
                           :background-color "black"
                           :color "white"
                           :padding "5px 5px 0px 50px"]
                      [:body
                           :background-color "#444"]))

(defn index-page []
  "index page for richever"
  (html5
   [:head 
    [:title "Richever Technology Ltd. Regina Saskatchewan"]
    (include-css "/vendor/bootstrap/css/bootstrap.min.css")
    (include-css "/vendor/bootstrap/css/bootstrap-responsive.css")
    (include-css "/vendor/font-awesome/css/font-awesome.min.css")
    [:style in-css]
    (include-js "/vendor/bootstrap/js/bootstrap.min.js")
    (include-js "/app.js")]
   [:body
    [:div.row-fluid.navigation_bar "this is navigation bar"]
    ]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 3000 :join? false}))