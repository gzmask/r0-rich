(ns r0_rich.controls.port
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def gallery_news [ {:title "new design news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(deftemplate port (html port_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
