(defproject org.clojars.gzmask/richweb "0.1.0-SNAPSHOT"
  :description "richever.ca"
  :url "http://richever.ca"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.8.5"]]
  :dependencies [[ring/ring-core "1.1.8"]
                 [ring/ring-jetty-adapter "1.1.8"]
                 [enlive "1.1.1"]
                 [org.clojars.gzmask/rich_pos "0.2.0-SNAPSHOT"]
                 [compojure "1.1.5"]
                 [org.clojure/clojure "1.5.1"]]
  :source-paths ["src/clj"]
  :ring {:handler richweb.handle/app
         :auto-relod? true}
  :main richweb.handle
  :profiles {:uberjar {:aot [richweb.handle]}}
  :cljsbuild{:builds [{:source-paths ["src/cljs"],
                       :compiler {:output-to "resources/public/app.js",
                                  :optimizations :whitespace,
                                  :pretty-print true}
                       :jar true}]})
