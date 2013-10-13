(ns hello-world.routes
  (:use compojure.core
        [hello-world.views :as views]
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.response :as response]))

(defroutes app-routes
  (GET "/" [] (views/index-page))
  (GET "/home" [] (views/index-page))
  (GET "/about" [] (views/about-page))
  (GET "/contact" [] (views/contact-page))
  (GET "/blah" [] (views/blah-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (wrap-base-url)))
