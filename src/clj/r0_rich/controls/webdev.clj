(ns r0_rich.controls.webdev
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def dev_news [ {:title "web development news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(deftemplate webdev (html webdev_pg) []
  [:div#news_feed :ul :li] (clone-for [new dev_news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
