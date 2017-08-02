/*
package gd;

import com.glassdoor.search.jobs.api.entity.JobListingQueryField;
import com.glassdoor.search.jobs.api.request.JobSearchRequest;
import com.glassdoor.search.jobs.api.request.query.QueryParams;
import com.glassdoor.search.jobs.behavior.SearchBehavior;
import com.glassdoor.search.jobs.criteria.SearchCriteria;
import com.glassdoor.search.jobs.solr.query.SolrQueryBuilderImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.request.SolrQueryRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;


public class ExecuteTests extends GDBaseTestClass {

    ExecuteTests executeTests;

    */
/**
     * @param jsonPath
     * @param thisClass
     * @param <T>
     * @return
     *//*

    public static <T> T populateFromJson(String jsonPath, Class<T> thisClass) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(jsonPath), thisClass);
    }

    public String coreName() {
        return "jobs_us";
    }

    */
/**
     * clears existing indexes and populates index with records listed under index_docs.csv
     *
     * @throws IOException
     *//*

    @Before
    public void init() throws IOException {
        executeTests = new ExecuteTests();
        executeTests.populateIndex("testcases_io/index_docs.csv");
    }

    */
/**
     * Populates search query and executes test cases listed under test_cases.csv
     *
     * @throws IOException
     *//*

    @Test
    public void executeTests() throws IOException {
        executeTests.runTests("testcases_io/test_cases.csv",
                getJobSearchRequest(), getSearchBehavior());
    }

    public JobSearchRequest getJobSearchRequest() throws IOException {
        Gson gson = new Gson();
        JobSearchRequest defaultJobSearchReq = new JobSearchRequest();
        JsonObject defaultJSRJsonObj = gson.toJsonTree(defaultJobSearchReq).getAsJsonObject();

        JobSearchRequest jobSearchRequest = executeTests.
                populateFromJson("testcases_io/job_search_request.json", JobSearchRequest.class);
        JsonObject jsrJsonObj = gson.toJsonTree(jobSearchRequest).getAsJsonObject();

        return gson.fromJson(mergeJsonObjects(defaultJSRJsonObj, jsrJsonObj), JobSearchRequest.class);

    }

    public SearchBehavior getSearchBehavior() throws IOException {
        Gson gson = new Gson();
        SearchBehavior defaultSearchBehavior = new SearchBehavior();
        JsonObject defaultSBJsonObj = gson.toJsonTree(defaultSearchBehavior).getAsJsonObject();

        SearchBehavior searchBehavior = executeTests.
                populateFromJson("testcases_io/job_search_request.json", SearchBehavior.class);
        JsonObject sbJsonObj = gson.toJsonTree(searchBehavior).getAsJsonObject();

        return gson.fromJson(mergeJsonObjects(defaultSBJsonObj, sbJsonObj), SearchBehavior.class);

    }

    */
/**
     * Run test cases listed in the given input file.
     * File is expected to consist of following tab separated columns: 1) solr's request handler name, 2) search keywords list separated by pipe
     * 3) expected results separated by comma, provided in xpath format.example:
     * select	software engineer|search engineer	"/*/
/*[@numFound='2']", "//result/doc[1]/long[@name='jobListingId'][.=10]"
     *
     * @param testCasesFilePath test cases listed file
     * @param jobSearchRequest
     * @param searchBehavior
     * @throws IOException
     *//*

    public void runTests(String testCasesFilePath, JobSearchRequest jobSearchRequest, SearchBehavior searchBehavior) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new
                    BufferedReader(new FileReader(getCWDTestResourcesDir() + testCasesFilePath));

            //skip header
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split("\\|");
                for (int i = 0; i < strings.length; i++) {
                    System.out.println(strings[i]);
                    jobSearchRequest.askFor(QueryParams.keywords(JobListingQueryField.KEYWORDS, strings[1].trim().split(";")));
                    System.out.println(" keywords set: " + Arrays.toString(jobSearchRequest.getSearchKeywords().toArray()));
                    SearchCriteria searchCriteria = new SearchCriteria(jobSearchRequest, searchBehavior);

                    SolrQueryBuilderImpl solrQueryBuilderImpl = new SolrQueryBuilderImpl();
                    // SolrQuery solrQuery = solrQueryBuilderImpl.buildFrom(searchCriteria);
                    SolrQuery solrQuery = solrQueryBuilderImpl.buildFrom(searchCriteria);
                    solrQuery.set(CommonParams.QT, strings[0].trim());

                    System.out.println("req hand set: " + solrQuery.getRequestHandler());
                    SolrQueryRequest req = req(solrQuery);

                    assertQ("",
                            req,
                            strings[2].trim()
                    );
                }
            }
        } finally {
            bufferedReader.close();
            System.out.println("done");

        }
    }

    */
/**
     * Clears existing index and populates Index with documents provided in csv file,
     * Reads first row as field names and following rows as solr input document (each row maps to single solr input doc)
     *
     * @param inputDocsPath
     * @throws IOException
     *//*

    public void populateIndex(String inputDocsPath) throws IOException {
        clearIndex();
        inputDocsPath = getCWDTestResourcesDir() + inputDocsPath;
        Reader in = new FileReader(inputDocsPath);
        CSVParser csvParser = CSVFormat.DEFAULT.withSkipHeaderRecord().withIgnoreSurroundingSpaces().withFirstRecordAsHeader().withCommentMarker('#').withIgnoreEmptyLines(true).parse(in);
        for (CSVRecord record : csvParser.getRecords()) {
            ImmutableList.Builder<String> builder = new ImmutableList.Builder<>();
            record.toMap().forEach((key, val) -> builder.add(key).add(val));
            assertU(adoc(Iterables.toArray(builder.build(), String.class)));
        }
        assertU(commit());
    }

    public String getCWD() {
        return Paths.get(".").toAbsolutePath().
                resolveSibling("search-jobs-core").normalize().toString();
    }

    public String getCWDTestResourcesDir() {
        return getCWD() + "/src/test/resources/";
    }

    //todo: to check if this should go into util class and as static method?
    public JsonObject mergeJsonObjects(JsonObject... jsonObjects) throws JSONException {

        JsonObject jsonObject = new JsonObject();

        for (JsonObject temp : jsonObjects) {
            Iterator<Map.Entry<String, JsonElement>> keys = temp.entrySet().iterator();
            while (keys.hasNext()) {
                Map.Entry<String, JsonElement> key = keys.next();
                jsonObject.add(key.getKey(), key.getValue());
            }

        }
        return jsonObject;
    }


    */
/*


*/
/*    *//*
*/
/*
     * Populates JobSearchRequest object via Json provided in the given input file.
     *
     * @return JobSearchRequest
     * @throws IOException
     *//*
*/
/*
    public JobSearchRequest populateJobSearchRequest(String jobSearchRequestJson) throws IOException {
        jobSearchRequestJson = getCWDTestResourcesDir() + jobSearchRequestJson;
        Gson gson = new Gson();
        JobSearchRequest jobSearchRequest = gson.fromJson(new FileReader(jobSearchRequestJson), JobSearchRequest.class);
        return jobSearchRequest;
    }*//*





*/
/*    *//*
*/
/*
     * Populates JobSearchBehavior object via Json provided in the given input file.
     *
     * @param searchBehaviorJson path to file that consist of SearchBehavior in json format
     * @return SearchBehavior
     * @throws IOException
     *//*
*/
/*
    public SearchBehavior populateJobSearchBehavior(String searchBehaviorJson) throws IOException {
        searchBehaviorJson = getCWDTestResourcesDir() + searchBehaviorJson;
        Gson gson = new Gson();
        SearchBehavior searchBehavior = gson.fromJson(new FileReader(searchBehaviorJson), SearchBehavior.class);
        return searchBehavior;
    }*//*

        */
/*@RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = JobSearchCoreAppContext.class)
    @ThreadLeakFilters(filters = {ExecuteTests.IgnoreSchedulerThreadFilter.class})*//*

    */
/*private TestContextManager testContextManager;

  //


    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("shards.location", "http://localhost:8983/solr/jobs_us");
        String filePath = "solr-configs/" + "jobs_us/collection1/";
        SolrTestCaseJ4.initCore("solrconfig.xml", "schema.xml",
                getFile(filePath).getParentFile().getAbsolutePath());
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("do nothing: just say end");
    }

    @Before
    public void setUpContext() throws Exception {
        //todo : before tests are
        //this is where the magic happens, we actually do "by hand" what the spring runner would do for us,
        // read the JavaDoc for the class bellow to know exactly what it does, the method names are quite accurate though
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }


    @Override
    public void setUp() throws Exception {
        super.setUp();
        log.info("### Setting up " + getTestName());
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static class IgnoreSchedulerThreadFilter implements ThreadFilter {
        @Override
        public boolean reject(final Thread t) {
            return t.getName().equals("commons-pool-EvictionTimer")
                    || t.getThreadGroup() != null
                    && t.getThreadGroup().getName().contains("ScoringV4ITest");
        }
    }
 *//*

}

 /* *//**
 * @return
 * @throws IOException
 * @return
 * @throws IOException
 * @return
 * @throws IOException
 *//*
    public JobSearchRequest getJobSearchRequest() throws IOException {
        Gson gson = new Gson();
        JobSearchRequest defaultJobSearchReq = new JobSearchRequest();
        JsonObject defaultJSRJsonObj = gson.toJsonTree(defaultJobSearchReq).getAsJsonObject();

        JobSearchRequest customJobSearchRequest = executeTests.populateFromJson("testcases_io/job_search_request.json", JobSearchRequest.class);
        JsonObject customJSRJsonObj = gson.toJsonTree(customJobSearchRequest).getAsJsonObject();

        return gson.fromJson(mergeJsonObjects(defaultJSRJsonObj, customJSRJsonObj), JobSearchRequest.class);

    }

    *//**
 * @return
 * @throws IOException
 *//*
    public SearchBehavior getSearchBehavior() throws IOException {
        Gson gson = new Gson();
        SearchBehavior defaultSearchBehavior = new SearchBehavior();
        JsonObject defaultSBJsonObj = gson.toJsonTree(defaultSearchBehavior).getAsJsonObject();

        SearchBehavior customSearchBehavior = executeTests.populateFromJson("testcases_io/job_search_request.json", SearchBehavior.class);
        JsonObject customSBJsonObj = gson.toJsonTree(customSearchBehavior).getAsJsonObject();

        return gson.fromJson(mergeJsonObjects(defaultSBJsonObj, customSBJsonObj), SearchBehavior.class);

    }
*/




