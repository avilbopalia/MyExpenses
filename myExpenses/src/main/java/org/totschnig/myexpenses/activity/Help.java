/*   This file is part of My Expenses.
 *   My Expenses is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   My Expenses is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with My Expenses.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.totschnig.myexpenses.activity;

import org.totschnig.myexpenses.dialog.HelpDialogFragment;

import android.content.ComponentName;
import android.os.Bundle;

public class Help extends ProtectedFragmentActivityNoAppCompat {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String activityName;
    ComponentName callingActivity = getCallingActivity();
    if (callingActivity!=null) {
      activityName = callingActivity.getShortClassName();
      //trim leading .
      activityName = activityName.substring(activityName.lastIndexOf(".")+1);
    } else {
      activityName = "MyExpenses";
    }
    Enum<?> variant = (Enum<?>) getIntent().getSerializableExtra(HelpDialogFragment.KEY_VARIANT);
    HelpDialogFragment.newInstance(activityName,variant).show(getSupportFragmentManager(),"HELP");
  }
}
