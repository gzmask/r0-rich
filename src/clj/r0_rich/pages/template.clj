(ns r0_rich.pages.template
  (:use hiccup.core
        hiccup.page)
  (:require [clojure.string :as s]))


(defn def_nav [navs icons]
  (list (map (fn [nav icon] 
               (list [:div.span2 [:a.nav_bn {:href (str (s/lower-case (s/replace nav #"_|-|\s" "")))}[(keyword (str "i." icon)) nav]]]))
             navs icons)))

(def nav_bar (def_nav ["Home" "Regina Store" "Web Design" "PC Repair" "Portfolio" "About"] 
                      ["icon-home" "icon-fighter-jet" "icon-folder-open" "icon-lightbulb" "icon-lightbulb" "icon-lightbulb"]))

(defn pages [content]
  "get page by pagename"
  (list
   [:head 
    [:title "Richever Technology Ltd"]
    (include-css "/vendor/bootstrap/css/bootstrap.min.css")
    (include-css "/vendor/bootstrap/css/bootstrap-responsive.css")
    (include-css "/vendor/font-awesome/css/font-awesome.min.css")
    (include-css "/style.css")]
   [:body
    [:div#loading [:img#rotation_logo {:src "/img/richever_logo.png"}] [:br] [:h3 "loading..."]]
    [:div.row-fluid [:div.top_bar {:style "background-color:#ccc"} " "]
                    [:div.top_bar {:style "background-color:#031F73"} " "]
                    [:div.top_bar {:style "background-color:#0A96A6"} " "]
                    [:div.top_bar {:style "background-color:#F2B138"} " "]
                    [:div.top_bar {:style "background-color:#F26A1B"} " "]
                    [:div.top_bar {:style "background-color:#BF2C0B"} " "]]
    [:div#navi_bar.row-fluid nav_bar]
    content
    (include-js "/app.js")]))

