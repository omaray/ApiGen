{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Translate API{% endsetvar %}
  {% setvar product_name %}Translate{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/translate/v2/getting_started{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/translate/v2/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/translate{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/translate/v2/using_rest{% endsetvar %}
{% endblock %}


{% block page_description %}
With Google Translate, you can dynamically translate text between thousands of language pairs. To learn more about Translate, see <a href="https://cloud.google.com/translate/docs">What is Translate?</a>
{% endblock %}