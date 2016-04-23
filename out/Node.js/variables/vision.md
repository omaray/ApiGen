{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Google Cloud Vision API{% endsetvar %}
  {% setvar product_name %}Google Cloud Vision{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/vision/docs/getting-started{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/vision/v1/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/vision{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/vision/reference/rest/{% endsetvar %}
{% endblock %}


{% block page_description %}
Cloud Vision API allows developers to easily integrate vision detection features within applications, including image labeling, face and landmark detection, optical character recognition (OCR), and tagging of explicit content. To learn more about Google Cloud Vision, see <a href="https://cloud.google.com/vision/docs/">What is Google Cloud Vision?</a>
{% endblock %}