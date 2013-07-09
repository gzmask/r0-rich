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
            background-color: #1A1E24;
            background-repeat: no-repeat;
            background-position: 10px 50px;
            background-size: 1280px 800px;
            color: #FFFFFF;
            font-family: advent-Bd1;}
          div.content {
            font-size: 20px;}
          div.top_bar {
            height: 4px;
            width: 16%;
            float: left;}
          #navi_bar {
            background-image: url('/img/richever_logo.png');
            background-color: #1A1E24;
            background-repeat: no-repeat;
            background-position: 615px 150px;
            padding: 50px 0px 20px 0px;
            height: 70px;
            transition: background-color 500ms ease,height 1500ms ease;}
          #navi_bar:hover {
            background-color: #000;
            height: 200px;
          }
          @font-face {
            font-family: advent-Re;
            src: url('fonts/advent-Re.otf');}
          @font-face {
            font-family: advent-Lt1;
            src: url('fonts/advent-Lt1.otf');}
          @font-face {
            font-family: advent-Bd1;
            src: url('fonts/advent-Bd1.otf');}
          hr {
            border: 0;
            height: 1px;
            background: #555;
            background: -webkit-gradient(linear, 0 0, 100% 0, from(#1A1E24), to(#1A1E24), color-stop(50%, #555));}
          .nav_bn {
            color:#6C7381;
            font-size: 22px;
            font-family: advent-Re;
            transition: color 1s ease,font-size 200ms ease;}
          .nav_bn:hover {
            font-size: 25px;
            color:#F5F5F5;}
          .circle { 
            width: 140px;
            height: 240px;
            padding: 8px 70px 8px 70px;
            font-size: 25px;
            background: #AEB6BD; 
            background-image: url('/img/richever_logo.png');
            background-position: -150px 0px;
            background-repeat: no-repeat;
            -moz-border-radius: 70px; 
            -webkit-border-radius: 70px; 
            border-radius: 70px;
            padding-top: 239px;
            transition: padding-top 1s ease, background-position 1s ease;}
          .circle:hover {
            padding-top: 95px;
            background-position: 0px 0px;
          }
          #loading {
            padding: 150px 0 0 615px;
            background: black;
            width: 100%;
            overflow:hidden;
            position: absolute;
            z-index: 10;
            height: 100%;
            transition: opacity 2s ease, visibility 0s linear 2s;
          }
          @-webkit-keyframes rotation {
            from {-webkit-transform: rotate(0deg);}
            to {-webkit-transform: rotate(360deg);}
          }
          @keyframes rotation {
            from {-webkit-transform: rotate(0deg);}
            to {-webkit-transform: rotate(360deg);}
          }
          #rotation_logo {
            -webkit-animation: rotation 2s infinite linear;
          }
          a:link {color:#6C7381;}
          a:visited {color:#6C7381; }
          a:hover {text-decoration: none;}
          a:active {color:#6C7381;}
          "})

(defn def_page [title body]
  "compose page, convert title as id"
  (list  
    [:hr]
    [:h2.offset5 title]
    [:hr]
    [:div.row-fluid {:id (str "pg_" (s/lower-case (s/replace title #"_|-|\s" "")))} 
     body]))

(defn def_nav [navs icons]
  (list (map (fn [nav icon] 
               (list [:div.span2 [:a.nav_bn {:href (str (s/lower-case (s/replace nav #"_|-|\s" "")))}[(keyword (str "i." icon)) nav]]]))
             navs icons)))

(def home_pg (def_page "Home" 
               (list 
                [:div.span3.offset1.circle "Web Design"]
                [:div.span3.circle "Regina Store"]
                [:div.span3.circle "Computer Repair"])))
(def start_pg (def_page "Getting Start" 
                "This is Getting Start"))
(def port_pg (def_page "Portfolio" 
               "This is Portfolio"))
(def about_pg (def_page "About" 
                "This is About"))
(def no_pg (def_page "404" 
             "404 not found"))
(def nav_bar (def_nav ["Home" "Regina Store" "Web Design" "PC Repair" "Portfolio" "About"] 
                      ["icon-home" "icon-fighter-jet" "icon-folder-open" "icon-lightbulb" "icon-lightbulb" "icon-lightbulb"]))

(defn pages [page]
  "get page by pagename"
  (html5
   [:head 
    [:title "ctl testing page"]
    (include-css "/vendor/bootstrap/css/bootstrap.min.css")
    (include-css "/vendor/bootstrap/css/bootstrap-responsive.css")
    (include-css "/vendor/font-awesome/css/font-awesome.min.css")
    (include-css "/style.css")]
   [:body
    [:div#loading [:img#rotation_logo {:src "/img/richever_logo.png"}] [:br] [:h3 "loading..."]]
    [:div.row-fluid [:div.top_bar {:style "background-color:#ccc"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#031F73"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#0A96A6"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#F2B138"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#F26A1B"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#BF2C0B"} "&nbsp;"]]
    [:div#navi_bar.row-fluid nav_bar]
    (cond
      (= page "home") [:div.row-fluid.home home_pg]
      (= page "gettingstart") [:div.row-fluid.start  start_pg]
      (= page "portfolio") [:div.row-fluid.port  port_pg]
      (= page "about") [:div.row-fluid.about  about_pg]
      :else [:div.row-fluid.home no_pg])]
    (include-js "/app.js")))

(defroutes app-routes
  (GET "/style.css" [] (css))
  (route/resources "/")
  (GET "/" [] (pages "home"))
  (GET "/:page" [page] (pages page))
  (route/not-found (pages "404")))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 3000 :join? false}))


(comment "repl: cpr - load all cpp - eval at point"
(defonce server (run-jetty #'app {:port 3000 :join? false}))
(.start server)
(.stop server)
)
