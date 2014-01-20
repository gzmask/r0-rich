(ns richweb.controls.control
  (:use richweb.pages.page
        net.cgrand.enlive-html)
  (:require [clojure.xml :as xml]))

(defn wordpress-xml-parse [xmlurl]
  (let [xmlfeed (xml/parse xmlurl)]
    (into []
    (for [x (:content ((:content xmlfeed) 0)) :when (= :item (:tag x))]
      {:title ((:content ((:content x) 0)) 0)
       :time ((:content ((:content x) 3)) 0)
       :body ((:content ((:content x) 8)) 0)}))))

(def home_news 
  (wordpress-xml-parse "http://richeverregina.wordpress.com/category/home/feed/"))

(def store_news 
  (wordpress-xml-parse "http://richeverregina.wordpress.com/category/store/feed/"))

(def dev_news 
  (wordpress-xml-parse "http://richeverregina.wordpress.com/category/web/feed/"))

(def repair_news 
  (wordpress-xml-parse "http://richeverregina.wordpress.com/category/pc/feed/"))

(def gallery_news 
  (wordpress-xml-parse "http://richeverregina.wordpress.com/category/portfolio/feed/"))

(def team_news 
  (wordpress-xml-parse "http://richeverregina.wordpress.com/category/about/feed/"))

(deftemplate home (html home_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                                        [:div.newshead] (content (:title item))
                                        [:div.newsbody] (html-content (:body item))
                                        [:div.newstime] (content (:time item))))

(deftemplate store (html store_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (html-content (:body item))))

(deftemplate webdev (html webdev_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (html-content (:body item))))

(deftemplate repair (html repair_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (html-content (:body item))))

(deftemplate port (html port_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (html-content (:body item))))

(deftemplate about (html about_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (html-content (:body item))))

(deftemplate no (html no_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (html-content (:time item))
                              [:div.newsbody] (content (:body item))))
