(ns r0_rich.controls.control
  (:use r0_rich.pages.page
        net.cgrand.enlive-html))

(def home_news [ 
                {:title "Welcome Message:" 
                 :time "26th, July, 2013"
                 :body [:div "Hello Dear customers. This is Richever Tech. We are a group of technology enthusiasts. We believe that computers can be cost effective and green, yet powerful. We are working hard to bring affordable computing technologies to Regina. We have an affordable line of linux powered PCs in store, and variable mobile accessories to enable your mobile devices. As for businesses, we got a team of high portfolio web developers to help your business growth. Welcome."]}
                {:title "Store open!" 
                 :time "24th, July, 2013"
                 :body [:div "Store is now open. Welcome to our store at 2139 8th Ave. We are having an openning sale event in store right now."]}
                {:title "Store grand openning" 
                 :time "16th, July, 2013"
                 :body [:div "Store is openning this week."]}
                {:title "Web Site Launch" 
                 :time "10th, July, 2013"
                 :body [:div "Welcome to Richever.ca. Our website is still under very heavy development. Please check back on us frequently and you will be able to see lots of improvements."]}])

(def store_news [ {:title "Richever Store open"
                   :time "24th, July, 2013" 
                   :body [:div "Our brick-and-mortar store is now open at 2139 8th Ave, Regina, Saskatchewan! Please checkout our openning sale."]}])

(def dev_news [{:title "Immediate response web apps" 
                :time "30th, July, 2013" 
                :body [:div "An immediate response web site is that you click into a button of the website, it gives the result immediately without loading the internet for information results. Carmens' Tea is an immediate response website: " [:a {:href "http://www.carmenstea.ca"} "Carmens' Tea"]]}
               {:title "Web office" 
                :time "26th, July, 2013" 
                :body [:div "Our Web Development office is open at 2139 8th Ave, Regina"]} 
               {:title "Carmen's tea is launched!"
                :time "1st, May, 2013"
                :body [:div "please visit " 
                       [:a {:href "http://www.carmenstea.ca"} "Carmens Tea "] 
                       "to check it out!"]}
               {:title "C&W renovations is launched!"
                :time "2nd, April, 2013"
                :body [:div "please visit "
                       [:a {:href "http://www.cwrenos.ca"} "C&W Renos"]
                       " to check it out!"]}])

(def repair_news [ {:title "university discount"
             :time "26th, July, 2013"
             :body [:div "10% off discount for all university students and employees."]} ])

(def gallery_news [ {:title "design news"
             :time "20th, July, 2013"
             :body [:div "no news yet"]}])

(def team_news [ {:title "member news"
             :time "20th, July, 2013"
             :body [:div "no news yet"]}])

(def no_news [ {:title "404 not found"
             :time "20th, July, 2013"
             :body [:div "a not found is good found"]}])

(deftemplate home (html home_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                                        [:div.newshead] (content (:title item))
                                        [:div.newsbody] (content (html (:body item)))
                                        [:div.newstime] (content (:time item))))

(deftemplate store (html store_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (content (html (:body item)))))

(deftemplate webdev (html webdev_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (content (html (:body item)))))

(deftemplate repair (html repair_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (content (html (:body item)))))

(deftemplate port (html port_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (content (html (:body item)))))

(deftemplate about (html about_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (content (html (:body item)))))

(deftemplate no (html no_pg) [news]
  [:div#news_feed.row-fluid] (clone-for [item news]
                              [:div.newshead] (content (:title item))
                              [:div.newstime] (content (:time item))
                              [:div.newsbody] (content (html (:body item)))))
