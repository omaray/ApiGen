{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Stackdriver Logging API{% endsetvar %}
  {% setvar product_name %}Stackdriver Logging{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/logging/docs/quickstart-sdk{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/logging/v2beta1/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/logging{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/logging/docs/api/introduction_v2{% endsetvar %}
{% endblock %}


{% block page_description %}
Stackdriver Logging collects and stores logs from applications and services in Google Cloud Platform (GCP) and Amazon Web Services (AWS). To learn more about Stackdriver Logging, see <a href="https://cloud.google.com/logging/docs/">What is Stackdriver Logging?</a>
{% endblock %}