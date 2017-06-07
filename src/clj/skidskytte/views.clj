(ns skidskytte.views
  (:require [hiccup.core :as h]
            [hiccup.page :as hp]))


(def fb-api "<div id=\"fb-root\"></div>
  <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1&appId=404540083024310\";
  fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));</script>")

(def fb-like-button "<div class=\"fb-like\" data-href=\"http://www.skidskytteroulette.se\" data-layout=\"standard\" data-action=\"like\" data-show-faces=\"true\" data-share=\"true\"></div>")

(def tweet-button "<a href=\"https://twitter.com/share\" class=\"twitter-share-button\" data-url=\"http://www.skidskytteroulette.se\" data-text=\"Hitta din nya sport på \" data-lang=\"sv\">Tweeta</a>
  <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>")

(def google-analytics "<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-160245-6', 'skidskytteroulette.se');
  ga('send', 'pageview');

  </script>")

(defn script [src]
  [:script {:type "text/javascript" :src src}])

(defn style [href]
  [:link {:rel :stylesheet :href href}])

(defn styles [& urls]
  (for [url urls] (style url)))

(defn js-var [var value]
  (str "var " (name var) "=" value ";"))

(defn base [sport]
  (hp/html5
   [:head
    [:meta {:charset "utf-8"}]
    [:title "Skidskytteroulette"]
    [:meta {:name "viewport" :content "width=device-width" :initial-scale "1"}]
    [:meta { :name "google-site-verification" :content "r7VtbOM8b_7mep2VcJfOfm1FhQl5R9w-I9C_yoJm90k"}]
    (hp/include-css "/assets/bootstrap/css/bootstrap.min.css")
    (hp/include-css "/assets/font-awesome/css/font-awesome.min.css")
    (hp/include-css "/css/screen.css")
    (hp/include-css "/css/custom.css")]
   [:body
    [:div.container
     [:div.inner
      [:h1 "Skidskytteroulette"]
      [:p "Om du gillar skidskytte och nordisk kombination så kanske du också gillar"]
      [:p#sport.sport [:span sport]]
      [:p.something-else "Nja, det låter trist, jag vill pröva "
       [:span#link [:a {:href "/"} "något annat"]]]
      [:div.fb-like.social fb-like-button]
      [:div.tweet-button.social tweet-button]]]
    (script "/js/app.js")
    [:div google-analytics fb-api]]))
