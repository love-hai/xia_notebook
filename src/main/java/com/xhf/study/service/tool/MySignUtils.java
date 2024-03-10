package com.xhf.study.service.tool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 签名
 *
 * @author xiahaifeng
 * @since 2024/3/10 14:37
 */

@Slf4j
public class MySignUtils {
    private static final String SIGN = "H4sIAAAAAAAAAK2Wv6qjQBTG3yKFBIQUIQsBST/kOZaU6bJTWW2xkv5qv4WwjbDuFgGxH9Kts4Xg\n" +
            "G2wZshAQnUpt9pzRG//mRpcLFjo6n9/8zjlzRsTn4v2u/OOPL9F7ChZ/99/i7XsKxt/Nz2z6LCYi\n" +
            "8ujt1w9/xCS1mZ14RETKwSNWeHyE8eA6Vu9V5g4I8ojQ+f7g2olrH1yWeA8xmlrv1dXpCyYn/cUj\n" +
            "NAKThM7sTxqxumGtMOYrvIrYkeIyUtHCgomtj30aKTR4XbULMDc08DvQKozgR1qyUNwpv+nYzjUC\n" +
            "iwUpcEgRoyIfN6DfwwiWACOSTCuRhVRuCb7gdHKQS04QIJoEmCLwkyZwxLgwV07pDW5AvHwsb2qA\n" +
            "sMYAYmEfTvt0xXioA0Pxm6HPcCd6GJ9eEI5UI8CQhrtq8GbASLpkYJtH26nZmOFiFTAp1FYyWAEs\n" +
            "n9R/GV/UF3SSrvVOqmQnA2xDdGpXY4saEyY57Rsj2xovRP8hRoc+0pyBSUXEjCPAI4zwCuYOBHk/\n" +
            "G8v0WwF/hDNQPvFCqBv5u01drXMdzEMVNG00MGLCmEsQtAetZi7D3910SJtyyRQFt5lnt75sYERj\n" +
            "oHZ1isEaj/0cavNm8Pn+dVElLqeE0McoC2RBqzIcJDlM2Loj7WJ03sQIs/x+oNEJfNxI0QktRq2d\n" +
            "8Ms5Xx+rAF3PQdPApBZzHfPZ/7WYVrw6I81szH7aT6bfW9XMMdeykKOunyGMA+2moYmurMCGrZIO\n" +
            "CTYx5uWWeMUtcTDWeN2O+cqGoPO5ToeW3MGYa6Xyk4hD3d0j1V9Oa28sQznU/uor1Kl6zjy8N5dM\n" +
            "1vUbGJ0nGH/jrsVvRx5AkTqFyoqrzztRmJKNXDbo1w3cx2y/MDE3oH03PIzPRpZqCmzU6aoZC9sK\n" +
            "d+0fjT/wQAN1oIH+8kijy2CrFaEB7RUa0BDGx9fNwIYlp7/Uvd7H5nJBtvLVcTzGfMmgL5trA+cG\n" +
            "DsjK8S12amiCqlIegfhojHAyASnc+SMmYvQjD2OKrALY1Qn4L4KzkLvuGIypJs9gUoeGOgqednKx\n" +
            "MiIIrbzHvW4URhX7vhVtS3sF3txJEql256aMw8jkuY4VyH/4m8bh+TnGaWfp+PwPRj0GcMMMAAA=";

    public static void sign() {
        String sign = MyGZIPUtils.uncompressStringToString(SIGN);
        sign = sign.replace("\n", "").replace("\r", "");
        // 将sign根据@符号分割成数组
        String[] signSplit = sign.split("line");
        for (String s : signSplit) {
            s = s.replace("\n", "").replace("\r", "");
            s += "==xiahaifeng";
            log.info(s);
        }
    }
}