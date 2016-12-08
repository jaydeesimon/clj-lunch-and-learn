(ns clojure-lunch-and-learn.spec
  (:require [clojure.spec :as s])
  (:gen-class))

(s/def ::sourcing_strategy_key
  #{ "CANDIDATE_SEARCH"
     "COMPANY_MARKETING"
     "OTHER"
     "JOB_BOARDS"
     "ATTEND_EVENTS"
     "REFERRALS"
     "SOCIAL_MEDIA"
     "AGENCIES"})

(s/def ::strategies (s/coll-of ::sourcing_strategy_key))

(s/valid? ::sourcing_strategy_key "blahblah")
(s/explain ::sourcing_strategy_key "blahblah")
(s/explain ::strategies ["OTHER" "AGENCIES" "blahblah"])
