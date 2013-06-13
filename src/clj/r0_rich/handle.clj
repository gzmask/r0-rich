(ns r0_rich.handle
  (:use compojure.core
        hiccup.core
        hiccup.page
        ring.adapter.jetty)
  (:require [gaka [core :as gaka]]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defn css [] 
  {:headers {"Content-Type" "text/css"}
   :body (gaka/css [:body :background-color "#444"
                   [:div.navigation_bar :background-color "#ccc" 
                                        :color "#fff" 
                                        :height "25px" 
                                        :padding "5px 5px 0px 50px"]
                   [:i.icon-camera-retro :color "#000"]])})

(defn index-page []
  "index page for richever"
  (html5
   [:head 
    [:title "Richever Technology Ltd. Regina Saskatchewan"]
    (include-css "/vendor/bootstrap/css/bootstrap.min.css")
    (include-css "/vendor/bootstrap/css/bootstrap-responsive.css")
    (include-css "/vendor/font-awesome/css/font-awesome.min.css")
    (include-css "/style.css")
    (include-js "/vendor/bootstrap/js/bootstrap.min.js")
    (include-js "/app.js")]
   [:body
    [:div.row-fluid.navigation_bar [:i.icon-camera-retro] "&nbsp; this is navigation bar"]
    ]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/style.css" [] (css))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 3000 :join? false}))
