(ns r0_rich.controls.home
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def home_news [ {:title "first news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(deftemplate home (html home_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
