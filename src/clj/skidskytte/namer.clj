(ns skidskytte.namer)

(def nationalities [
                    "baltisk"
                    "brittisk"
                    "dansk"
                    "finsk"
                    "fransk"
                    "grekisk"
                    "nordisk"
                    "norsk"
                    "rysk"
                    "tysk"])

(def prefixes [
               "armbrytnings"
               "backhoppnings"
               "badminton"
               "bandy"
               "baseboll"
               "basket"
               "biljard"
               "bordtennis"
               "boule"
               "bowling"
               "boxnings"
               "breakdance"
               "bridge"
               "brottnings"
               "brännboll"
               "bågskytte"
               "bänkpress"
               "curling"
               "cykel"
               "dart"
               "dubbel"
               "dyknings"
               "diskus"
               "dragkamps"
               "enduro"
               "fallskärmshopps"
               "forspaddlings"
               "fotbolls"
               "frisbee"
               "fäktnings"
               "golf"
               "gång"
               "handbolls"
               "hockey"
               "häcklöpnings"
               "häst"
               "höjdhopps"
               "isjakts"
               "innebandy"
               "judo"
               "karate"
               "kendo"
               "kanot"
               "klättrings"
               "konstsims"
               "konståknings"
               "lacrosse"
               "landhockey"
               "längdhopps"
               "löpnings"
               "maraton"
               "mountainbike"
               "orienterings"
               "polo"
               "ponny"
               "rally"
               "rodd"
               "rodel"
               "rugby"
               "seglings"
               "segway"
               "simhopps"
               "simnings"
               "skateboard"
               "skytte"
               "slalom"
               "styrkelyfts"
               "störtlopps"
               "snowboard"
               "sumobrottning"
               "telemarks"
               "tennis"
               "tjurfäktnings"
               "tyngdlyftnings"
               "trampolin"
               "slungbolls"
               "slägg"
               "skid"
               "skridsko"
               "speedway"
               "spjut"
               "sprint"
               "taekwando"
               "trestegs"
               "undervattens"
               "vatten"
               "volleyboll"
               "windsurfings"])


(def suffixes [
               "armbrytning"
               "backhoppning"
               "badminton"
               "bandy"
               "baseboll"
               "basket"
               "biljard"
               "bordtennis"
               "boule"
               "bowling"
               "boxning"
               "breakdance"
               "bridge"
               "brottning"
               "brännboll"
               "bågskytte"
               "bänkpress"
               "casting"
               "curling"
               "cykel"
               "dart"
               "dykning"
               "diskus"
               "dragkamp"
               "enduro"
               "fallskärmshopp"
               "forspaddling"
               "fotboll"
               "frisbee"
               "fäktning"
               "golf"
               "gång"
               "handboll"
               "hockey"
               "häcklöpning"
               "höjdhopp"
               "innebandy"
               "judo"
               "karate"
               "kendo"
               "kanot"
               "klättring"
               "konstsim"
               "konståkning"
               "lacrosse"
               "landhockey"
               "lerduveskytte"
               "längdhopp"
               "löpning"
               "maraton"
               "orientering"
               "polo"
               "rally"
               "rodd"
               "rodeo"
               "rodel"
               "rugby"
               "segling"
               "simhopp"
               "simning"
               "skateboard"
               "skytte"
               "slalom"
               "stafett"
               "styrkelyft"
               "störtlopp"
               "snowboard"
               "snooker"
               "sumobrottning"
               "tennis"
               "tjurfäktning"
               "tyngdlyftning"
               "slungboll"
               "slägga"
               "skidor"
               "skridsko"
               "speedway"
               "spjut"
               "taekwando"
               "tresteg"
               "volleyboll"
               "windsurfing"
               "varpa"])



(defn random-word [word-list]
  (first (shuffle word-list)))

(defn has-nationality? []
  (= (rand-int 20) 1))

(defn nationality []
  (if (has-nationality?)
    (str (random-word nationalities) " ")
    ""))

(defn random-first-word []
  (random-word prefixes))

(defn random-second-word []
  (random-word suffixes))

(defn same-word-twice [word]
  (not (nil? (re-find #"(.{4,}).*\1" word))))

(defn two-sports []
  (str (nationality) (random-first-word) (random-second-word)))

(defn new-sport []
  (let [word (two-sports)]
    (if (same-word-twice word)
      (new-sport)
      word)))
