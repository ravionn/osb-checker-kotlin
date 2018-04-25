package de.evoila.obs.checker.response

import com.fasterxml.jackson.annotation.JsonProperty

class DashboardClient {

  var id: String = ""

  @JsonProperty("redirect_uri")
  var redirectUri = ""

  var secret = ""
}
