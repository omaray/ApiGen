{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Google Cloud Datastore API{% endsetvar %}
  {% setvar product_name %}Google Cloud Datastore{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/datastore/docs/quickstart{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/datastore/v1beta3/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/datastore{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/datastore/docs/apis/overview{% endsetvar %}
{% endblock %}


{% block page_description %}
Google Cloud Datastore is a NoSQL document database built for automatic scaling, high performance, and ease of application development. To learn more about Google Cloud Datastore, see <a href="https://cloud.google.com/datastore/docs/concepts/overview">What is Google Cloud Datastore?</a>
{% endblock %}