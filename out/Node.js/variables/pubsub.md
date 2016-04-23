{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Cloud Pub/Sub API{% endsetvar %}
  {% setvar product_name %}Cloud Pub/Sub{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/pubsub/prereqs{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/pubsub/v1/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/pubsub{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/pubsub/reference/rest/{% endsetvar %}
{% endblock %}


{% block page_description %}
Google Cloud Pub/Sub brings the scalability, flexibility, and reliability of enterprise message-oriented middleware to the cloud. To learn more about Cloud Pub/Sub, see <a href="https://cloud.google.com/pubsub/overview">What is Cloud Pub/Sub?</a>
{% endblock %}