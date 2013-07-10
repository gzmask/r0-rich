(ns r0_rich.controls.repair
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def repair_news [ {:title "university employee discount news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(deftemplate repair (html repair_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
