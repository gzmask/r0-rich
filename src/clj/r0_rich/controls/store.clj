(ns r0_rich.controls.store
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def store_news [ {:title "store news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(deftemplate store (html store_pg) []
  [:div#news_feed :ul :li] (clone-for [new store_news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
