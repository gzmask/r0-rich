(ns r0_rich.controls.no
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def no_news [ {:title "404 not found"
             :body "a not found is good found"}])

(deftemplate no (html no_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
