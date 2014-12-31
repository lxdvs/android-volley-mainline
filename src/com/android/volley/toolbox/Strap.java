package com.android.volley.toolbox;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class Strap extends HashMap<String, String> /**
 * HashMaps cannot be
 * Parcelable, see ParcelStrap
 */
{
	public static Strap make() {
		return new Strap();
	}

	public Strap kv(String k, String v) {
		put(k, v);
		return this;
	}

	public Strap kv(String k, long v) {
		return this.kv(k, Long.toString(v));
	}

	public Strap kv(String k, int v) {
		return this.kv(k, Integer.toString(v));
	}

	public Strap kv(String k, boolean v) {
		return this.kv(k, Boolean.toString(v));
	}

	public Strap mix(Strap strap) {
		if (strap == null) {
			return this;
		}
		for (Entry<String, String> entry : strap.entrySet()) {
			kv(entry.getKey(), entry.getValue());
		}
		return this;
	}

	public String getString(String key) {
		String value = super.get(key);
		return value != null ? value : "";
	}

	public JSONObject getJson() {
		JSONObject ob = new JSONObject();
		for (Entry<String, String> entry : entrySet()) {
			try {
				ob.put(entry.getKey(), entry.getValue());
			} catch (JSONException e) {
			}
		}
		return ob;
	}

	public String getJsonString() {
		return getJson().toString();
	}
}
