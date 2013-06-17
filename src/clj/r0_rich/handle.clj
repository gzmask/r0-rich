(ns r0_rich.handle
  (:use compojure.core
        hiccup.core
        hiccup.page
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn css [] 
  {:headers {"Content-Type" "text/css"}
   :body "body {
            background-color: #444;
            color: #E0771B;
            font-family: advent-Bd1;}
          div.content {
            padding: 15px 15px 50px 50px;}
          div.navigation_bar {
            background-color: #ccc;
            font-family: advent-Re;
            font-size: 26px;
            color: #fff;
            padding: 5px 5px 2px 50px;}
          @font-face {
            font-family: hildieb;
            src: url('fonts/hildieb.ttf');}
          @font-face {
            font-family: advent-Re;
            src: url('fonts/advent-Re.otf');}
          @font-face {
            font-family: advent-Lt1;
            src: url('fonts/advent-Lt1.otf');}
          @font-face {
            font-family: advent-Bd1;
            src: url('fonts/advent-Bd1.otf');}
          i.icon-camera-retro {
            color: #000;} "})

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
    [:div.row-fluid.navigation_bar [:div.span2 [:a [:i.icon-home] "Home"]]
                                   [:div.span2 [:a [:i.icon-fighter-jet] "Getting Start"]]
                                   [:div.span2 [:a [:i.icon-folder-open] "Portfolio"]]
                                   [:div.span2 [:a [:i.icon-lightbulb] "About"]]]
    [:div.row-fluid.content [:h1 "Simple stuff"]
                            [:div.row-fluid.home [:h2.offset1 "Home"]
                                                 [:div.row-fluid [:div.offset2.span2 "this is home"]]]
                            [:div.row-fluid.start [:h2.offset1 "Getting Start"]
                                                 [:div.row-fluid [:div.offset2.span2 "this is start"]]]
                            [:div.row-fluid.port [:h2.offset1 "Portfolio"]
                                                 [:div.row-fluid [:div.offset2.span2 "this is port"]]]
                            [:div.row-fluid.about [:h2.offset1 "About"]
                                                 [:div.row-fluid [:div.offset2.span2 "this is about"]]]]
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
