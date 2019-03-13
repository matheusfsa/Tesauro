/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class AIterationCmdCmd extends PCmd
{
    private PIterationCmd _iterationCmd_;

    public AIterationCmdCmd()
    {
        // Constructor
    }

    public AIterationCmdCmd(
        @SuppressWarnings("hiding") PIterationCmd _iterationCmd_)
    {
        // Constructor
        setIterationCmd(_iterationCmd_);

    }

    @Override
    public Object clone()
    {
        return new AIterationCmdCmd(
            cloneNode(this._iterationCmd_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIterationCmdCmd(this);
    }

    public PIterationCmd getIterationCmd()
    {
        return this._iterationCmd_;
    }

    public void setIterationCmd(PIterationCmd node)
    {
        if(this._iterationCmd_ != null)
        {
            this._iterationCmd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._iterationCmd_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._iterationCmd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._iterationCmd_ == child)
        {
            this._iterationCmd_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._iterationCmd_ == oldChild)
        {
            setIterationCmd((PIterationCmd) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
