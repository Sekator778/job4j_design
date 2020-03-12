//package ood;
//
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.*;
//
//@RunWith(Arquillian.class)
//public class TemplateTest {
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(Template.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
//
//}
