(ns r0_rich.pages.page
  (:use hiccup.core
        hiccup.page
        r0_rich.pages.template)
  (:require [clojure.string :as s]))

(defn def_page [title body]
  "compose page, convert title as id"
  (list  
    [:hr]
    [:h2.offset5 title]
    [:hr]
    [:div.row-fluid {:id (str "pg_" (s/lower-case (s/replace title #"_|-|\s" "")))} 
     body]))

(def home_pg (pages (def_page "Home" 
                (list 
                 [:div.span3.offset1.circle [:a {:href "/webdesign"} "Web Design"]]
                 [:div.span3.circle [:a {:href "/reginastore"} "Regina Store"]]
                 [:div.span3.circle [:a {:href "/pcrepair"} "Computer Repair"]]
                 [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]
                 ))))
(def store_pg (pages (def_page "Regina Richever Store" 
                       (list
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]))))
(def port_pg (pages (def_page "Portfolio" 
                       (list
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]))))
(def about_pg (pages (def_page "About" 
                       (list
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]))))
(def webdev_pg (pages (def_page "Web Design" 
                       (list
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]))))
(def repair_pg (pages (def_page "PC Repair service" 
                       (list
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]))))
(def no_pg (pages (def_page "404" 
                       (list
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]))))

