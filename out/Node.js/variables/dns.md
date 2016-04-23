{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Google Cloud DNS API{% endsetvar %}
  {% setvar product_name %}Google Cloud DNS{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/dns/getting-started{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/dns/v1/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/dns{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/dns/api/v1/{% endsetvar %}
{% endblock %}


{% block page_description %}
Publish your domain names using Google&#39;s infrastructure for production-quality, high-volume DNS services. To learn more about Google Cloud DNS, see <a href="https://cloud.google.com/dns/docs">What is Google Cloud DNS?</a>
{% endblock %}