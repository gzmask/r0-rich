(ns r0_rich.controls.control
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def home_news [ {:title "Store grand openning"
             :body "Our store is schduled to open at July"}
            {:title "Web Site Launch"
             :body "Welcome to Richever.ca"}])

(def store_news [ {:title "store news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(def dev_news [ {:title "web development news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(def repair_news [ {:title "university employee discount news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(def gallery_news [ {:title "new design news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(def team_news [ {:title "new member news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(def no_news [ {:title "404 not found"
             :body "a not found is good found"}])

(deftemplate home (html home_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [new news]
                                        [:div.head] (content (:title new))
                                        [:div.body] (content (:body new))))

(comment (deftemplate home (html home_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new)))))

(deftemplate store (html store_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))

(deftemplate webdev (html webdev_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))

(deftemplate repair (html repair_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))

(deftemplate port (html port_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))

(deftemplate about (html about_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))

(deftemplate no (html no_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
