(ns skidskytte.views
  (:require [hiccup.core :as h]
            [hiccup.page :as hp]))

(def matomo "<!-- Matomo -->
  <script type=\"text/javascript\">
  var _paq = _paq || [];
  /* tracker methods like 'setCustomDimension' should be called before 'trackPageView' */
  _paq.push(['trackPageView']);
  _paq.push(['enableLinkTracking']);
  (function() {
    var u=\"//analytics.marcusahnve.org/\";
  _paq.push(['setTrackerUrl', u+'piwik.php']);
  _paq.push(['setSiteId', '3']);
  var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
  g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
  })();
  </script>
  <!-- End Matomo Code -->")

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
    (hp/include-css "/css/custom.css")
    [:script {:type "text/javascript"
              :crossorigin "anonymous"
              :src "https://unpkg.com/@hotwired/turbo@7.0.0-beta.3/dist/turbo.es5-umd.js"}]
    matomo]
   [:body
    [:div.container
     [:div.inner
      [:h1 "Skidskytteroulette"]
      [:p "Om du gillar skidskytte och nordisk kombination så kanske du också gillar"]
      [:turbo-frame#the-sport
       [:p.sport [:span sport]]]
      [:p.something-else "Nja, det låter trist, jag vill pröva "
       [:span#link [:a {:href "/"} "något annat"]]]]]]))
