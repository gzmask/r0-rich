(ns r0_rich.controls.control
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def home_news [ 
                {:title "Store opens at July 24th" 
                 :body "Store is now opened. Welcome to visit us at 2139 8th Ave!"}
                {:title "Store grand openning" 
                 :body "Store is openning this week."}
                {:title "Web Site Launch" 
                 :body "Welcome to Richever.ca"}])

(def store_news [ {:title "store news"
             :body "We have our first batch of goods in store right now."}
            {:title "Importing goods from China."
             :body "Our goods are on the way."}])

(def dev_news [ {:title "web development news"
             :body "no news is good news"}
            {:title "Carment's tea is lunched!"
             :body "please visit carmenstea.ca to check it out!"}
            {:title "c&w renovations is lunched!"
             :body "please visit cwrenos.ca to check it out!"}])

(def repair_news [ {:title "university discount"
             :body "university students and employees will get 90% discount."} ])

(def gallery_news [ {:title "design news"
             :body "no news yet"}])

(def team_news [ {:title "member news"
             :body "no news yet"}])

(def no_news [ {:title "404 not found"
             :body "a not found is good found"}])

(deftemplate home (html home_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                                        [:div.newshead] (content (:title item))
                                        [:div.newsbody] (content (:body item))
                                        ))

(deftemplate store (html store_pg) [news]
  [:div#news_feed :ul :li] (clone-for [item news]
                              [:h2] (content (:title item))
                              [:div] (content (:body item))))

(deftemplate webdev (html webdev_pg) [news]
  [:div#news_feed :ul :li] (clone-for [item news]
                              [:h2] (content (:title item))
                              [:div] (content (:body item))))

(deftemplate repair (html repair_pg) [news]
  [:div#news_feed :ul :li] (clone-for [item news]
                              [:h2] (content (:title item))
                              [:div] (content (:body item))))

(deftemplate port (html port_pg) [news]
  [:div#news_feed :ul :li] (clone-for [item news]
                              [:h2] (content (:title item))/
                              [:div] (content (:body item))))

(deftemplate about (html about_pg) [news]
  [:div#news_feed :ul :li] (clone-for [item news]
                              [:h2] (content (:title item))
                              [:div] (content (:body item))))

(deftemplate no (html no_pg) [news]
  [:div#news_feed :ul :li] (clone-for [item news]
                              [:h2] (content (:title item))
                              [:div] (content (:body item))))
