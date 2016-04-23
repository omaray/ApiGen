{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}Google Cloud Dataproc API{% endsetvar %}
  {% setvar product_name %}Google Cloud Dataproc{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/dataproc/setup-project{% endsetvar %}
  {% setvar client_lib_url %}http://google.github.io/google-api-nodejs-client/4.0.0/index.html{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/dataproc/v1/{% endsetvar %}
  
  {% setvar api_reference_url %}{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/google/google-api-nodejs-client{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/dataproc/reference/rest/{% endsetvar %}
{% endblock %}


{% block page_description %}
Cloud Dataproc is a managed Spark and Hadoop service that lets you take advantage of open source data tools for batch processing, querying, streaming, and machine learning. To learn more about Google Cloud Dataproc, see <a href="https://cloud.google.com/dataproc/overview">What is Google Cloud Dataproc?</a>
{% endblock %}