(ns richweb.handle
  (:gen-class)
  (:use compojure.core
        richweb.controls.control
        richweb.pages.css
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [r0_rich.pages.css :as pos]
            [r0_rich.item.crud :as item]
            [r0_rich.item_type.crud :as item_type]
            [r0_rich.invoice.crud :as invoice]
            [r0_rich.session.log :as log]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/style.css" [] (css))
  (GET "/pos_bg_style.css" [] (pos/css))
  (route/resources "/")
  (GET "/" [] (home home_news))
  (GET "/home" [] (home home_news))
  (GET "/store" [] (store store_news))
  (GET "/web" [] (webdev dev_news))
  (GET "/pcrepair" [] (repair repair_news))
  (GET "/portfolio" [] (port gallery_news))
  (GET "/about" [] (about team_news))
  (GET "/items" {session :session} (item/index session))
  (GET "/items/new" {session :session} (item/new session))
  (POST "/items/create" {params :params session :session} (item/create params session))
  (GET "/items/:id" {params :params session :session} (item/show (:id params) session))
  (GET "/items/:id/single_update" {{id :id} :params session :session} (item/single_update id session))
  (POST "/items/:id/single_change" {params :params session :session} (item/single_change params session))
  (GET "/items/:id/update" {{id :id} :params session :session} (item/update id session))
  (POST "/items/:id/change" {params :params session :session} (item/change params session))
  (GET "/items/:id/single_remove" {{id :id} :params session :session} (item/single_remove id session))
  (GET "/items/:plucode/remove" {{plucode :plucode} :params session :session} (item/plu_remove plucode session))
  (GET "/invoices" {session :session} (invoice/index session))
  (GET "/invoices/new" {session :session} (invoice/new session))
  (POST "/invoices/create" {params :params session :session} (invoice/create params session))
  (GET "/invoices/:id" {params :params session :session} (invoice/show (:id params) session))
  (GET "/invoices/:id/update" {{id :id} :params session :session} (invoice/update id session))
  (POST "/invoices/:id/change" {params :params session :session} (invoice/change params session))
  (GET "/invoices/:id/remove" {{id :id} :params session :session} (invoice/aremove id session))
  (GET "/item_types" {session :session} (item_type/index session))
  (GET "/item_types/new" {session :session} (item_type/new session))
  (POST "/item_types/create" {params :params session :session} (item_type/create params session))
  (GET "/item_types/:id" {params :params session :session} (item_type/show (:id params) session))
  (GET "/item_types/:id/update" {{id :id} :params session :session} (item_type/update id session))
  (POST "/item_types/:id/change" {params :params session :session} (item_type/change params session))
  (GET "/item_types/:id/remove" {{id :id} :params session :session} (item_type/aremove id session))
  (GET "/login" {session :session} (log/login session))
  (GET "/logout" {session :session} (log/logout session))
  (POST "/check" {params :params session :session} (log/check (:username params) (:password params) session))
  (POST "/updateinvoice" {params :params session :session} (log/updateinvoice params session))

  (route/not-found (no no_news)))

(def app
  (handler/site app-routes))

(defn -main []
    (run-jetty #'app {:port 80 :join? false}))

(comment "repl"
(defonce server (run-jetty #'app {:port 3000 :join? false}))
(.start server)
(.stop server))
