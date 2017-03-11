package com.applicaster.demo;

import android.support.test.runner.AndroidJUnit4;

import com.applicaster.demo.dao.IOperationDAO;
import com.applicaster.demo.dao.TweetHistoryDAO;
import com.applicaster.demo.dao.TweetResponseDAO;
import com.applicaster.demo.helper.AppDatabaseHelper;
import com.applicaster.demo.helper.AppDatabaseManager;
import com.applicaster.demo.model.TweetHistory;
import com.applicaster.demo.model.TweetResponse;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.ForeignCollection;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
public class DemoInstrumentedTest {

    /**
     *ORMLite ForeignCollection Instrumentation Test
     */

    @Test
    public void IOForeignCollection() throws Exception {

        /**
        *Obtain the Database Helper
         */
        AppDatabaseHelper helper = AppDatabaseManager.getInstance().getHelper();

        /**
         *Create an instance of TweetResponse
         * */
        TweetResponse response = new TweetResponse(9999);

        /**
         *Persist TweetResponse
         * */
        new TweetResponseDAO(helper).Create(response, IOperationDAO.OPERATION_INSERT);

        /**
         *Create one instance of associated TweetHistory
         * */
        TweetHistory tweetHistory;
        tweetHistory = new TweetHistory();
        tweetHistory.setText("This a test");
        tweetHistory.setFavoriteCount(10);
        tweetHistory.setFollowersCount(10);
        tweetHistory.setName("Rafael Ambruster");
        tweetHistory.setRetweetCount(10);

        /**
         *Add the father TweetResponse to TweetHistory child
         */
        tweetHistory.setTweetResponse(response);

        /**
         *Persist TweetHistory
         */
        new TweetHistoryDAO(helper).Create(tweetHistory, IOperationDAO.OPERATION_INSERT);

        /**
         *Create another one instance of associated TweetHistory
         */

        tweetHistory = new TweetHistory();
        tweetHistory.setText("This a test number 2");
        tweetHistory.setFavoriteCount(15);
        tweetHistory.setFollowersCount(15);
        tweetHistory.setName("Mr Ran");
        tweetHistory.setRetweetCount(15);

        tweetHistory.setTweetResponse(response);

        /**
         *Persist TweetHistory
         */
        new TweetHistoryDAO(helper).Create(tweetHistory, IOperationDAO.OPERATION_INSERT);

        /**
         *Obtain Responses
         */
        TweetResponse resp = new TweetResponseDAO(helper).Get(response);

        /**
         *Obtain ForeignCollection
         */
        ForeignCollection<TweetHistory> tweets = resp.getTweetHistory();

        /**
         * Sanity checks
         * */
        CloseableIterator<TweetHistory> iterator = tweets.closeableIterator();
        try {
            assertTrue(iterator.hasNext());
            TweetHistory history = iterator.next();
            assertEquals("This a test", history.getText());
            assertTrue(iterator.hasNext());
            history = iterator.next();
            assertEquals("This a test number 4", history.getText());
            assertFalse(iterator.hasNext());
        } finally {
            iterator.close();
        }

        /**
         * Check ForeignCollection size in database
         * */
        assertEquals(2, tweets.size());
    }
}
