(ns r0_rich.controls.about
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def team_news [ {:title "new member news"
             :body "no news is good news"}
            {:title "second news"
             :body "no news is good news"}])

(deftemplate about (html about_pg) [news]
  [:div#news_feed :ul :li] (clone-for [new news]
                              [:h2] (content (:title new))
                              [:div] (content (:body new))))
