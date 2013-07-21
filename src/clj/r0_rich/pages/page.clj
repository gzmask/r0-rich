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

(def home_pg (pages (def_page "Richever Tech Ltd"
                (list
                 [:div.row-fluid
                  [:div.span3.offset1.circle.icon1 [:a.circle.icon {:href "/web"} "Web Design"]]
                  [:div.span3.circle.icon2 [:a.circle.icon {:href "/store"} "Regina Store"]]
                  [:div.span3.circle.icon3 [:a.circle.icon {:href "/pcrepair"} "PC Service"]]]
                 [:br] [:br]
                 [:div#news_feed.row-fluid
                  [:div.head.span2.offset2 "atitle"]
                  [:div.body.span8 "content"]]))))

(def store_pg (pages (def_page "Regina Richever Store"
                       [:div.row-fluid
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]])))
(def port_pg (pages (def_page "Portfolio"
                       [:div.row-fluid
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]])))
(def about_pg (pages (def_page "About"
                       [:div.row-fluid
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]])))
(def webdev_pg (pages (def_page "Web Design"
                       [:div.row-fluid
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]])))
(def repair_pg (pages (def_page "PC Repair service"
                       [:div.row-fluid
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]])))
(def no_pg (pages (def_page "404"
                       [:div.row-fluid
                        [:div#news_feed.span4.offset2 [:ul [:li [:h2 "news title"] [:div "news content"]]]]])))
