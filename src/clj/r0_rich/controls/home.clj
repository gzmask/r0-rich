(ns r0_rich.controls.home
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def news [ {:title "first news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(deftemplate home (html home_pg) []
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
