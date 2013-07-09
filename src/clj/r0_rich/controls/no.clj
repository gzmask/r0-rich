(ns r0_rich.controls.no
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def no_news [ {:title "404 not found"
             :body "no news is good news"}])

(deftemplate no (html no_pg) []
  [:div#news_feed :ul :li] (clone-for [new no_news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
