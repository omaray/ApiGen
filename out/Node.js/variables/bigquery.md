{% extends "_shared/templates/_silver_docs_api_page_node_veneer.html" %}

{% block pagevariables %}
  {% setvar api_name %}BigQuery API{% endsetvar %}
  {% setvar product_name %}BigQuery{% endsetvar %}
  {% setvar getting_started_url %}https://cloud.google.com/bigquery/sign-up{% endsetvar %}
  {% setvar client_lib_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/{% endsetvar %}
  {% setvar explorer_url %}https://developers.google.com/apis-explorer/#p/bigquery/v2/{% endsetvar %}
  
  {% setvar api_reference_url %}https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.30.2/bigquery{% endsetvar %}
  {% setvar client_lib_github_url %}https://github.com/GoogleCloudPlatform/gcloud-node{% endsetvar %} 
  {% setvar http_ref_url %}https://cloud.google.com/bigquery/docs/reference/v2/{% endsetvar %}
{% endblock %}


{% block page_description %}
Querying massive datasets can be time consuming and expensive without the right hardware and infrastructure. Google BigQuery solves this problem by enabling super-fast SQL queries against append-only tables using the processing power of Google&#39;s infrastructure. To learn more about BigQuery, see <a href="https://cloud.google.com/bigquery/what-is-bigquery">What is BigQuery?</a>
{% endblock %}