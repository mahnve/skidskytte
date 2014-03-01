(ns skidskytte.views
  (:require [hiccup.core :as h]
            [hiccup.page :as hp]))


(def fb-like-button "<div id=\"fb-root\"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1&appId=404540083024310\";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>")

(def tweet-button "<a href=\"https://twitter.com/share\" class=\"twitter-share-button\" data-url=\"http://skidskytteroulette.se\" data-text=\"Hitta din nya sport på \" data-lang=\"sv\">Tweeta</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>")

(def google-analytics "<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-160245-6', 'skidskytteroulette.se');
  ga('send', 'pageview');

</script>")

(defn main [name]
  (hp/html5
    [:head
     (hp/include-css "http://yui.yahooapis.com/pure/0.4.2/pure-min.css")
     (hp/include-css "/css/custom.css")]
    [:body
     [:div.container
       [:div.inner
        [:h1 "Skidskytteroulette"]
        [:p "Om du gillar skidskytte så kanske du också gillar"]
        [:p.sport name]
        [:p.something-else "Nja, det låter trist, jag vill pröva "
         [:a {:href "/"} "något annat"]]
        [:div.fb-like fb-like-button]
        [:div.tweet-button tweet-button]]]
     [:div google-analytics]]))

