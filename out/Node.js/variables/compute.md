{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Google Compute Engine API{% endsetvar %}
  {% setvar product_name %}Google Compute Engine{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/compute/docs/linux-quickstart{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/compute/v1/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/compute{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/compute/docs/reference/latest/{% endsetvar %}
{% endblock %}


{% block page_description %}
Google Compute Engine lets you create and run virtual machines on Google infrastructure. To learn more about Google Compute Engine, see <a href="https://cloud.google.com/compute/docs/">What is Google Compute Engine?</a>
{% endblock %}