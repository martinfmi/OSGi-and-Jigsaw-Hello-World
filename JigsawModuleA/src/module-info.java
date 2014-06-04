module org.bgjug @ 1.0 {
	// requires com.sample
	exports org.bgjug.seminar;
	requires jdk.base; // if not specified full JRE module ("jdk") will be required
	class com.bgjug.Main; // main entry point
}
