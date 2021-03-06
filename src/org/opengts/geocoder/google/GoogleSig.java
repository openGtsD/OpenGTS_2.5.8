// ----------------------------------------------------------------------------
// Copyright 2007-2015, GeoTelematic Solutions, Inc.
// All rights reserved
// ----------------------------------------------------------------------------
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
// ----------------------------------------------------------------------------
// Change History:
//  2011/07/01  Martin D. Flynn
//     -Initial release
// ----------------------------------------------------------------------------
package org.opengts.geocoder.google;

import java.math.BigInteger;
import java.net.URL;
import java.net.MalformedURLException;

import org.opengts.util.*;
import org.opengts.db.*;

public class GoogleSig
{

    // ------------------------------------------------------------------------

    private static final String ARG_SIGNATURE_  = "&signature=";
    
    private static final String HMACSHA1        = "HmacSHA1";

    // ------------------------------------------------------------------------

    private static MACProvider macProvider = null;
    
    public static void SetMACProvider(MACProvider mp)
    {
        GoogleSig.macProvider = mp;
    }
    
    // ------------------------------------------------------------------------
    // ------------------------------------------------------------------------

    private Object keyMac = null;

    public GoogleSig(String keyStr)
    {
        super();
    }

    // ------------------------------------------------------------------------

    /**
    *** Calculate and append Google "&signature=" hash.
    *** @param urlStr  The URL string to which the hash is appended.
    *** @return The URL string with the "&signature=" hash appended.
    **/
    public String signURL(String urlStr)
    {
        String sigURL = urlStr;
        // HMAC-SHA1 signature code here
        return sigURL;
    }

    // ------------------------------------------------------------------------

    public boolean validateURL(String urlStr)
    {
        // HMAC-SHA1 signature validation code here
        return false;
    }

    // ------------------------------------------------------------------------
    // ------------------------------------------------------------------------

    public static void main(String argv[])
    {
        RTConfig.setCommandLineArgs(argv);

        if (RTConfig.hasProperty("url")) {
            String urlStr = RTConfig.getString("url",null);
            String keyStr = RTConfig.getString("key",null);
            if (StringTools.isBlank(urlStr) || StringTools.isBlank(keyStr)) {
                Print.sysPrintln("ERROR: Missing url or key");
                System.exit(99);
            }
            GoogleSig gs = new GoogleSig(keyStr);
            String sigURL = gs.signURL(urlStr);
            Print.sysPrintln("");
            Print.sysPrintln(sigURL);
            Print.sysPrintln("");
            Print.sysPrintln("Validated: " + gs.validateURL(sigURL));
            System.exit(0);
        }

    }
    
}
