-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cool_blog
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `content` longtext NOT NULL,
  `creation_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_category` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_idx` (`id_category`),
  CONSTRAINT `fk_category_article` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'Servlets - Life Cycle','<p>A servlet life cycle can be defined as the entire process from its creation till the destruction. The following are the paths followed by a servlet.</p><ul><li>The servlet is initialized by calling the&nbsp;<strong>init()</strong>&nbsp;method.</li><li>The servlet calls&nbsp;<strong>service()</strong>&nbsp;method to process a client&#39;s request.</li><li>The servlet is terminated by calling the&nbsp;<strong>destroy()</strong>&nbsp;method.</li><li>Finally, servlet is garbage collected by the garbage collector of the JVM.</li></ul>','2018-06-18 09:17:55',1),(2,'Servlets - Form Data','<p>You must have come across many situations when you need to pass some information from your browser to web server and ultimately to your backend program. The browser uses two methods to pass this information to web server. These methods are GET Method and POST Method.</p><p><strong>GET Method</strong></p><p>The GET method sends the encoded user information appended to the page request. The page and the encoded information are separated by the&nbsp;<strong>?</strong>(question mark) symbol.</p><p>The GET method is the default method to pass information from browser to web server and it produces a long string that appears in your browser&#39;s Location:box. Never use the GET method if you have password or other sensitive information to pass to the server. The GET method has size limitation: only 1024 characters can be used in a request string.</p><p>This information is passed using QUERY_STRING header and will be accessible through QUERY_STRING environment variable and Servlet handles this type of requests using&nbsp;<strong>doGet()</strong>&nbsp;method.</p><p><strong>POST Method</strong></p><p>A generally more reliable method of passing information to a backend program is the POST method. This packages the information in exactly the same way as GET method, but instead of sending it as a text string after a ? (question mark) in the URL it sends it as a separate message. This message comes to the backend program in the form of the standard input which you can parse and use for your processing. Servlet handles this type of requests using&nbsp;<strong>doPost()</strong>&nbsp;method.</p>','2018-06-18 09:17:55',1),(3,'Servlets - Page Redirection','<p>Page redirection is a technique where the client is sent to a new location other than requested. Page redirection is generally used when a document moves to a new location or may be because of load balancing.</p><p>The simplest way of redirecting a request to another page is using method&nbsp;<strong>sendRedirect()</strong>&nbsp;of response object. Following is the signature of this method.</p>','2018-06-18 09:17:55',1),(4,'JSP - Lifecycle','<p>In this chapter, we will discuss the lifecycle of JSP. The key to understanding the low-level functionality of JSP is to understand the simple life cycle they follow.</p><p>A JSP life cycle is defined as the process from its creation till the destruction. This is similar to a servlet life cycle with an additional step which is required to compile a JSP into servlet.</p><p><strong>Paths Followed By JSP</strong></p><p>The following are the paths followed by a JSP &minus;</p><ul><li>Compilation</li><li>Initialization</li><li>Execution</li><li>Cleanup</li></ul>','2018-06-22 13:46:12',2),(5,'JSP - Directives','<p>In this chapter, we will discuss Directives in JSP. These directives provide directions and instructions to the container, telling it how to handle certain aspects of the JSP processing.</p><p>A JSP directive affects the overall structure of the servlet class. It usually has the following form:&nbsp;&lt;%@ directive attribute = &quot;value&quot; %&gt;</p>','2018-06-22 13:47:18',2),(6,'JSP - Actions','<p>In this chapter, we will discuss Actions in JSP. These actions use constructs in XML syntax to control the behavior of the servlet engine. You can dynamically insert a file, reuse JavaBeans components, forward the user to another page, or generate HTML for the Java plugin.</p><p>There is only one syntax for the Action element, as it conforms to the XML standard &minus; &lt;jsp:action_name attribute = &quot;value&quot; /&gt;</p>','2018-06-22 13:48:58',2),(7,'EJB - Stateless Bean','<p>A stateless session bean is a type of enterprise bean, which is normally used to perform independent operations. A stateless session bean as per its name does not have any associated client state, but it may preserve its instance state. EJB Container normally creates a pool of few stateless bean&#39;s objects and use these objects to process client&#39;s request. Because of pool, instance variable values are not guaranteed to be same across lookups/method calls.</p><p><strong>Steps to Create a Stateless EJB</strong></p><p>Following are the steps required to create a stateless EJB &minus;</p><ul><li><p>Create a remote/local interface exposing the business methods.</p></li><li><p>This interface will be used by the EJB client application.</p></li><li><p>Use @Local annotation, if EJB client is in same environment where EJB session bean is to be deployed.</p></li><li><p>Use @Remote annotation, if EJB client is in different environment where EJB session bean is to be deployed.</p></li><li><p>Create a stateless session bean, implementing the above interface.</p></li><li><p>Use @Stateless annotation to signify it a stateless bean. EJB Container automatically creates the relevant configurations or interfaces required by reading this annotation during deployment.</p></li></ul>','2018-06-22 13:49:39',3),(8,'EJB - Stateful Bean','<p>A stateful session bean is a type of enterprise bean, which preserve the conversational state with client. A stateful session bean as per its name keeps associated client state in its instance variables. EJB Container creates a separate stateful session bean to process client&#39;s each request. As soon as request scope is over, statelful session bean is destroyed.</p><p><strong>Steps to Create Stateful EJB</strong></p><p>Following are the steps required to create a stateful EJB &minus;</p><ul><li><p>Create a remote/local interface exposing the business methods.</p></li><li><p>This interface will be used by the EJB client application.</p></li><li><p>Use @Local annotation if EJB client is in same environment where EJB session bean need to be deployed.</p></li><li><p>Use @Remote annotation if EJB client is in different environment where EJB session bean need to be deployed.</p></li><li><p>Create a stateful session bean, implementing the above interface.</p></li><li><p>Use @Stateful annotation to signify it a stateful bean. EJB Container automatically creates the relevant configurations or interfaces required by reading this annotation during deployment.</p></li></ul>','2018-06-22 13:50:09',3),(9,'EJB - Persistence','<p>EJB 3.0, entity bean used in EJB 2.0 is largely replaced by persistence mechanism. Now entity bean is a simple POJO having mapping with table.</p><p>Following are the key actors in persistence API &minus;</p><ul><li><p><strong>Entity</strong>&nbsp;&minus; A persistent object representing the data-store record. It is good to be serializable.</p></li><li><p><strong>EntityManager</strong>&nbsp;&minus; Persistence interface to do data operations like add/delete/update/find on persistent object(entity). It also helps to execute queries using&nbsp;<strong>Query</strong>&nbsp;interface.</p></li><li><p><strong>Persistence unit (persistence.xml)</strong>&nbsp;&minus; Persistence unit describes the properties of persistence mechanism.</p></li><li><p><strong>Data Source (*ds.xml)</strong>&nbsp;&minus; Data Source describes the data-store related properties like connection url. user-name,password etc.</p></li></ul><p>To demonstrate EJB persistence mechanism, we need to do the following tasks &minus;</p><ul><li><p><strong>Step 1</strong>&nbsp;&minus; Create table in database.</p></li><li><p><strong>Step 2</strong>&nbsp;&minus; Create Entity class corresponding to table.</p></li><li><p><strong>Step 3</strong>&nbsp;&minus; Create Data Source and Persistence Unit.</p></li><li><p><strong>Step 4</strong>&nbsp;&minus; Create a stateless EJB having EntityManager instance.</p></li><li><p><strong>Step 5</strong>&nbsp;&minus; Update stateless EJB. Add methods to add records and get records from database via entity manager.</p></li><li><p><strong>Step 6</strong>&nbsp;&minus; A console based application client will access the stateless EJB to persist data in database.</p></li></ul>','2018-06-22 13:51:06',3);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `number_of_articles` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Servlet',3),(2,'JSP',3),(3,'EJB',3);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `link` varchar(50) NOT NULL,
  `position` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Statistics','statistic',1),(2,'Articles','article-list',1),(3,'Categories','category-list',1),(4,'Home','home',2),(5,'About Us','about',2);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-08 16:08:22
