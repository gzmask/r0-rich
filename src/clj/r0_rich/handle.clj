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
          div.navigation_bar {
            padding: 50px 0px 20px 0px;
            font-size: 25px;
            color: #fff;
            transition: background-color,height 500ms;}
          div.navigation_bar:hover {
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
          a:link {
            color:#6C7381;
            font-family: advent-Re;
            transition: color 500ms;}
          a:visited {color:#6C7381;font-family: advent-Re; }
          a:hover {color:#F5F5F5;font-family: advent-Re; }
          a:active {color:#6C7381;font-family: advent-Re; }
          "})

(defn def_page [title body]
  "compose page, convert title as id"
  (list  
    [:hr]
    [:h2.offset3 title]
    [:hr]
        [:div.row-fluid {:id (str "pg_" (s/lower-case (s/replace title #"_|-|\s" "")))} 
          [:div.span10.offset1 body]]))

(defn def_nav [navs icons]
  (list [:div.span1 ""] 
        (map (fn [nav icon] 
               (list [:div.span2 [:a {:href (str (s/lower-case (s/replace nav #"_|-|\s" "")))}[(keyword (str "i." icon)) nav]]]))
             navs icons)))

(def home_pg (def_page "Home" 
               (list 
                 [:div.row-fluid
                 [:div.span3.trans_bg {:style "color:#E5533C;"} 
                  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris consectetur dolor at posuere vehicula. Ut nec pretium felis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin a pellentesque magna, sit amet congue nulla. Pellentesque quis egestas eros. Integer eget laoreet urna. Maecenas eu aliquam urna. Sed sit amet ullamcorper quam."]
                 [:div.span3.trans_bg {:style "color:#F5E346;"} 
                  
                  "Vestibulum dictum quam in vulputate gravida. Sed id purus quis erat commodo eleifend. Etiam blandit diam elit, in laoreet mauris ullamcorper eget. Quisque ac enim rhoncus, convallis eros sollicitudin, egestas ipsum. Praesent ultricies, lorem id tristique dictum, nisi nulla cursus augue, ut tincidunt lorem massa id felis. Sed sit amet tellus dui. Curabitur vulputate molestie odio. Etiam hendrerit leo eget tincidunt tempus. Pellentesque a turpis id est vestibulum blandit ut et leo. Fusce rhoncus auctor turpis vitae ullamcorper. Mauris varius lectus ac orci facilisis faucibus."
                  [:br] [:br]
                  [:img {:src "/img/img2.jpg"}]]
                 [:div.span2.trans_bg {:style "color:#93D06D;"} 
                  [:img {:src "/img/img1.jpg"}]
                  [:br] [:br]
                  "Pellentesque nisi neque, aliquam quis imperdiet id, sagittis nec diam. Phasellus vestibulum id mi in volutpat. Donec ut facilisis sem. Morbi sed mi iaculis, rutrum neque quis, lobortis quam. Vestibulum rhoncus ut neque quis dictum. Curabitur quam dolor, pellentesque ac lacinia non, imperdiet nec tortor. Cras sit amet vehicula diam, ut fermentum ante. Nullam varius tristique turpis et mollis. Vivamus congue et sem sit amet luctus."]
                 [:div.span2.trans_bg {:style "color:#50AC6A;"} 
                  [:img {:src "/img/img4.jpg"}]
                  [:br] [:br]
                  "Aliquam blandit aliquet hendrerit. Integer placerat diam quis sapien tincidunt, quis tempus risus lacinia. Nunc nec ligula mauris. Nunc imperdiet vehicula condimentum. Vestibulum volutpat gravida eros, vitae ullamcorper nulla congue id. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut rhoncus congue quam quis congue. Maecenas eget lacinia erat."]
                 [:div.span2.trans_bg {:style "color:#227864;"} 
                  [:img {:src "/img/img5.jpg"}]
                  [:br] [:br]
                  "Aenean quis eleifend eros, id gravida diam. Proin pellentesque mattis quam, et eleifend augue rhoncus sed. Ut nec egestas massa. Vivamus quis malesuada tellus, et ornare nulla. Curabitur dictum purus lorem, non vehicula purus condimentum nec. Proin ullamcorper, justo eget vulputate malesuada, elit ipsum semper neque, in semper nisl arcu vel nulla. Vestibulum nec ipsum convallis, porta tortor eu, lacinia enim."]])))
(def start_pg (def_page "Getting Start" 
                "This is Getting Start"))
(def port_pg (def_page "Portfolio" 
               "This is Portfolio"))
(def about_pg (def_page "About" 
                "This is About"))
(def no_pg (def_page "404" 
             "404 not found"))
(def nav_bar (def_nav ["Home" "Getting-Start" "Portfolio" "About"] 
                      ["icon-home" "icon-fighter-jet" "icon-folder-open" "icon-lightbulb"]))

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
    [:div.row-fluid [:div.top_bar {:style "background-color:#ccc"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#031F73"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#0A96A6"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#F2B138"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#F26A1B"} "&nbsp;"]
                    [:div.top_bar {:style "background-color:#BF2C0B"} "&nbsp;"]]
    [:div.row-fluid.navigation_bar nav_bar]
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
