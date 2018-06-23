package star.tsafe;

import tsafe.Driver_TS_R;
import tsafe.EngineParameters;
import tsafe.Fix;
import tsafe.LatLonBounds;
import tsafe.Route;
import tsafe.RouteTrack;
import tsafe.SimpleCalculator;
import tsafe.TrajectorySynthesizer;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		Driver_TS_R driver = new Driver_TS_R();
		LatLonBounds bounds = new LatLonBounds(0,0,0,0);
		SimpleCalculator calc = new SimpleCalculator(bounds);
		EngineParameters params = new EngineParameters();
		TrajectorySynthesizer trajSynth = new TrajectorySynthesizer(calc, params);
		RouteTrack track = new RouteTrack(new Fix("", 0, 0), new Fix("", 0, 0), 0, 0, 0, 0, 0, 0);
		Route route = new Route();
		try {
			driver.TS_R_3(trajSynth, track, route);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
