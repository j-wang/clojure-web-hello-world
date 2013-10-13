(ns hello-world.views
  (:use [hiccup core page]
        [clojure.string :only [lower-case]]))

(def link-banner '("Home" "About" "Contact" "Blah"))

(defn template-page 
  "Base template page."
  [title body-text]
  (html5
   [:head
    [:title title]
    (include-css "/css/bootstrap.min.css"
                 "/css/styles.css")]
   [:body
    [:div {:class "top-banner"}
     [:h1 "Hello world!!!"]]
   [:div {:class "link-banner"}
    (for [x link-banner]
      [:div {:class "linky"}
       [:a {:href (str (lower-case x))} x]])]
    [:div {:class "arbitrary-text"}
     [:p body-text]]]))

(defn index-page 
  "Base index page."
  []
  (template-page "Index" "Arbitrary text to test out the Clojure web stack!"))

(defn about-page
  "The about page."
  []
  (template-page "About" "This is an about page!"))

(defn contact-page
  "The contact page."
  []
  (template-page "Contact" "Yeah, contact me, and stuff."))

(defn blah-page
  "This can be some other page."
  []
  (template-page "Blah" "Blah blah"))
