(ns r0_rich.handle
  (:use compojure.core
        hiccup.core
        hiccup.page
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [clojure.string :as s]
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

(defn def_page [title body]
  (list [:h2.offset1 title] 
        [:div.row-fluid {:id (str "pg_" (s/lower-case (s/replace title #"\s" "")))} 
        [:div.offset2.span2 body]]))

(defn def_nav [navs icons]
  (map (fn [nav icon]
         (list [:div.span2 [:a [(keyword (str "i." icon)) nav]]]))
       navs icons))

(def home_pg (def_page "Home" "This is Home"))
(def start_pg (def_page "Getting Start" "This is Getting Start"))
(def port_pg (def_page "Portfolio" "This is Portfolio"))
(def about_pg (def_page "About" "This is About"))
(def nav_bar (def_nav ["Home" "Getting_Start" "Portfolio" "About"] 
                      ["icon-home" "icon-fighter-jet" "icon-folder-open" "icon-lightbulb"]))

(defn index-page []
  "index page for richever"
  (html5
   [:head 
    [:title "ctl testing page"]
    (include-css "/vendor/bootstrap/css/bootstrap.min.css")
    (include-css "/vendor/bootstrap/css/bootstrap-responsive.css")
    (include-css "/vendor/font-awesome/css/font-awesome.min.css")
    (include-css "/style.css")]
   [:body
    [:div.row-fluid.navigation_bar nav_bar]
    [:div.row-fluid.content [:h1 "Simple stuff"]
                            [:div.row-fluid.home home_pg]
                            [:div.row-fluid.start  start_pg]
                            [:div.row-fluid.port  port_pg]
                            [:div.row-fluid.about  about_pg]]
    (include-js "/app.js")]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/style.css" [] (css))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 3000 :join? false}))


(comment "repl: cpr - load all cpp - eval at point"
(defonce server (run-jetty #'app {:port 3000 :join? false}))
(.start server)
(.stop server)
)
